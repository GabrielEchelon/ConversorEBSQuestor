package br.questor.teste.ebs.control;

public class Executer {
    
    protected int AUXILIAR = 0;
    
    public void Executer(){
        try{
            ContadorDAO contador = new ContadorDAO();
            contador.contadorQuery();
        
            ImpostoDAO impostodao = new ImpostoDAO();
            impostodao.impostoQuery();
        
            ConselhoProfisDAO conselhoprofisdao = new ConselhoProfisDAO();
            conselhoprofisdao.conselhorProfisQuery();
        
            EmpresaDAO empresadao = new EmpresaDAO();
            empresadao.empresaQuery();
        
            EstabDAO estabdao = new EstabDAO();
            estabdao.estabQuery();
        
            SocioDAO socioDAO = new SocioDAO();
            socioDAO.socioQuery();
        
            CFGEmpresaGEMDAO CFGEmpresaGEMDAO = new CFGEmpresaGEMDAO();
            CFGEmpresaGEMDAO.CFGEmpresaGEMQuery();
        
            CFGEmpresaFPADAO cfgempresafpadao = new CFGEmpresaFPADAO();
            cfgempresafpadao.CFGEmpresaFPAQuery();
            
            CFGEmpresaFPAOpcaoDAO cfgempresafpaopcaodao = new CFGEmpresaFPAOpcaoDAO();
            cfgempresafpaopcaodao.CFGEmpresaFPAOpcaoQuery();
        
            TabelaGPSDAO tabelagpsdao = new TabelaGPSDAO();
            tabelagpsdao.tabelaGPSQuery();  
            
            GPSDAO gpsdao = new GPSDAO();
            gpsdao.gpsQuery();
            
            CFGEstabFPADAO cfgestabfpadao = new CFGEstabFPADAO();
            cfgestabfpadao.CFGEmpresaFPAQuery();
        
            LocalContabilDAO localcontabildao = new LocalContabilDAO();
            localcontabildao.localContabilQuery();
        
            OutraEmpresaDAO outraempresadao = new OutraEmpresaDAO();
            outraempresadao.OutraEmpresaQuery();

            LotacaoDAO lotacaodao = new LotacaoDAO();
            lotacaodao.lotacaoQuery();  
        
            FuncPessoaDAO funcpessoadao = new FuncPessoaDAO();
            funcpessoadao.funcPessoaQuery();

            OrganogramaDAO organogramadao = new OrganogramaDAO();
            organogramadao.OrganogramaQuery();
        
            SindicatoDAO sindicatodao = new SindicatoDAO();
            sindicatodao.sindicatoQuery();

            FuncContratoDAO funccontratodao = new FuncContratoDAO();
            funccontratodao.funcContratoQuery();
        
            DependenteDAO dependentedao = new DependenteDAO();
            dependentedao.dependenteQuery();
        
            FuncSalarioDAO funcSalariodao = new FuncSalarioDAO();
            funcSalariodao.funcSalarioQuery();
        
            CboDAO cbodao = new CboDAO();
            cbodao.cboQuery();
            
            CargoDAO cargodao = new CargoDAO();
            cargodao.cargoQuery();
        
            FuncCargoDAO funccargodao = new FuncCargoDAO();
            funccargodao.funcCargoQuery();
            
            TerceiroDAO terceirodao = new TerceiroDAO();
            terceirodao.terceiroQuery();
            
            PeriodoAquisDAO periodoaquisdao = new PeriodoAquisDAO();
            periodoaquisdao.periodoAquisQuery();
            
            ReciboFeriasDAO reciboferiasdao = new ReciboFeriasDAO();
            reciboferiasdao.reciboFeriasQuery();
            
            FuncAnotacaoDAO funcanotacaodao = new FuncAnotacaoDAO();
            funcanotacaodao.funcAnotacaoQuery();
            
            FeriadoDAO feriadodao = new FeriadoDAO();
            feriadodao.feriadoQuery();
            
            HorarioDAO horariodao = new HorarioDAO();
            horariodao.horarioQuery();
            
            HorarioDetalheDAO horariodetalhedao = new HorarioDetalheDAO();
            horariodetalhedao.horarioDetalheQuery();
            
            EscalaDAO escaladao = new EscalaDAO();
            escaladao.escalaQuery();
            
            FuncEscalaDAO funcescaladao = new FuncEscalaDAO();
            funcescaladao.funcescalaQuery();
            
            FuncOutroContrDAO funcoutrocontrdao = new FuncOutroContrDAO();
            funcoutrocontrdao.funcoutrocontrQuery();
            
            FuncLocalDAO funclocaldao = new FuncLocalDAO();
            funclocaldao.funclocalQuery();
            
            AfastamentoDAO afastamentodao = new AfastamentoDAO();
            afastamentodao.afastamentoQuery();
            
            FuncAdicionalDAO funcadicionaldao = new FuncAdicionalDAO();
            funcadicionaldao.funcAdicionalQuery();
            
            TerceiroBancoDAO terceirobancoodao = new TerceiroBancoDAO();
            terceirobancoodao.terceiroBancoQuery();
            
            TerceiroPgtoDAO terceiropgtodao = new TerceiroPgtoDAO();
            terceiropgtodao.terceiroPgtoQuery();
            
            FuncOutraEmpDAO funcoutraempdao = new FuncOutraEmpDAO();
            funcoutraempdao.funcOutraEmpQuery();
            
            INSSCompDAO insscompdao = new INSSCompDAO();
            insscompdao.inssCompQuery();
            
            MotivoDemissaoDAO motivodemissaodao = new MotivoDemissaoDAO();
            motivodemissaodao.motivoDemissaoQuery();
            
            LinhaTranspDAO linhatranspdao = new LinhaTranspDAO();
            linhatranspdao.linhaTranspQuery();
            
            ValorLinTranspDAO valorlintranspdao = new ValorLinTranspDAO();
            valorlintranspdao.valorLinTranspQuery();
            
            EscalaVTDAO escalavtdao = new EscalaVTDAO();
            escalavtdao.motivoDemissaoQuery();
            
            PensaoJudDAO pensaojuddao = new PensaoJudDAO();
            pensaojuddao.pensaoJudQuery();
            
            QST_PeriodoCalculoDAO qstperiodocalculodao = new QST_PeriodoCalculoDAO();
            qstperiodocalculodao.periodoCalculoQuery();
            
            QST_FuncLocalDAO qstfunclocaldao = new QST_FuncLocalDAO();
            qstfunclocaldao.qstfunclocalQuery();
            
            FuncPerCalculoDAO funcpercalculodao = new FuncPerCalculoDAO();
            funcpercalculodao.funcPerCalculoQuery();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
